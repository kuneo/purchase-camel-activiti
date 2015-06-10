package jp.cameluser.camel.logic;

import java.util.List;
import java.util.Map;

import jp.cameluser.camel.model.PurchaseModel;
import jp.cameluser.camel.service.PurchaseMapper;

import org.activiti.camel.ActivitiProducer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * separated records entry database and prepare communication activiti-process
 */
public class EntryPurchase implements Processor {

	private Logger LOG = Logger.getLogger(getClass().getName());

	@Autowired
	private PurchaseMapper mapper;

	/**
	 * camel-process
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void process(Exchange exchange) throws Exception {
		LOG.debug("### Start: camel process " + getClass());

		// entry database to manage purchase goods
		Map map = (Map) exchange.getIn().getBody(List.class).get(0);
		PurchaseModel model = (PurchaseModel) map.get(PurchaseModel.class.getName());
		model.setStatus("entry");
		mapper.insertPurchase(model);
		LOG.info(model.getId());

		// prepare communication activiti-process
		exchange.setProperty(ActivitiProducer.PROCESS_KEY_PROPERTY, model.getId());
		exchange.getIn().setBody(model);

		LOG.debug("###   End: camel process " + getClass());
	}
}
