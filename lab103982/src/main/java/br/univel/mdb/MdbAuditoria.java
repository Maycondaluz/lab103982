package br.univel.mdb;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "MdbAuditoria", activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "topic/VENDATopic"),
	    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
	    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
	    })
public class MdbAuditoria implements MessageListener {

	private final static Logger LOGGER = Logger.getLogger(MdbAuditoria.class.toString());

	@Override
	public void onMessage(Message rcvMessage) {


		TextMessage msg = null;
        try {
            if (rcvMessage instanceof TextMessage) {
                msg = (TextMessage) rcvMessage;
                LOGGER.info("Received Message from topic: " + msg.getText());
            } else {
                LOGGER.warning("Message of wrong type: " + rcvMessage.getClass().getName());
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

	}

}