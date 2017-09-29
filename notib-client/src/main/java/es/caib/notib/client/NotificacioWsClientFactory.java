/**
 * 
 */
package es.caib.notib.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;
import javax.naming.NamingException;
import javax.xml.namespace.QName;

import org.jboss.mx.util.MBeanProxyCreationException;

import es.caib.loginModule.client.AuthenticationFailureException;
import es.caib.notib.ws.notificacio.NotificacioService;

/**
 * Utilitat per a instanciar clients SOAP per al servei d'enviament
 * de notificacions de NOTIB.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class NotificacioWsClientFactory {

	public static NotificacioService getWsClient(
			URL wsdlResourceUrl,
			String endpoint,
			String userName,
			String password) throws MalformedURLException, InstanceNotFoundException, MalformedObjectNameException, MBeanProxyCreationException, RemoteException, NamingException, CreateException, AuthenticationFailureException {
		return new WsClientHelper<NotificacioService>().generarClientWs(
				wsdlResourceUrl,
				endpoint,
				new QName(
						"http://www.caib.es/notib/ws/notificacio",
						"NotificacioService"),
				userName,
				password,
				NotificacioService.class);
	}

	public static NotificacioService getWsClient(
			String endpoint,
			String userName,
			String password) throws MalformedURLException, InstanceNotFoundException, MalformedObjectNameException, MBeanProxyCreationException, RemoteException, NamingException, CreateException, AuthenticationFailureException {
		return new WsClientHelper<NotificacioService>().generarClientWs(
				endpoint,
				new QName(
						"http://www.caib.es/notib/ws/notificacio",
						"NotificacioService"),
				userName,
				password,
				NotificacioService.class);
	}

}
