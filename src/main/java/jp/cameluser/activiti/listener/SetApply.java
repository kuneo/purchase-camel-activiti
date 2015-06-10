package jp.cameluser.activiti.listener;

import jp.cameluser.camel.model.PurchaseModel;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.log4j.Logger;

public class SetApply implements JavaDelegate {

	private Logger LOG = Logger.getLogger(getClass().getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.debug("### Start: activiti listener " + getClass());

		PurchaseModel model = (PurchaseModel) execution.getVariable("camelBody");
		model.setStatus("apply");
		execution.setVariable("camelBody", model);

		LOG.debug("### Start: activiti listener " + getClass());
	}
}
