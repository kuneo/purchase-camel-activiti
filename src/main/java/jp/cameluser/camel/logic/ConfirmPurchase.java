package jp.cameluser.camel.logic;

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
public class ConfirmPurchase implements Processor {

	private Logger LOG = Logger.getLogger(getClass().getName());

	@Autowired
	private PurchaseMapper mapper;

	/**
	 * camel-process
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		LOG.debug("### Start: camel process " + getClass());

		PurchaseModel model = new PurchaseModel();
		model.setId(exchange.getIn().getHeader("processKey", Integer.class));
		model.setStatus("confirm");
		mapper.updatePurchase(model);

		// prepare communication activiti-process
		exchange.setProperty(ActivitiProducer.PROCESS_KEY_PROPERTY, model.getId());
		exchange.getIn().setBody(model);

		LOG.debug("###   End: camel process " + getClass());
	}
}
