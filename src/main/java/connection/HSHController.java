/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package connection;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.net.URI;
import java.net.URISyntaxException;

public class HSHController implements MqttCallback {

    private String topic = "outTopic";
    private MqttClient client;

    public HSHController() throws MqttException {
        this.client = new MqttClient("tcp://192.168.0.10:1883", "MQTT-Java-Example", new MemoryPersistence());
        this.client.setCallback(this);
        this.client.connect();

        this.client.subscribe(this.topic);
    }

    /**
     * @see MqttCallback#connectionLost(Throwable)
     */
    public void connectionLost(Throwable cause) {
        System.out.println("Connection lost because: " + cause);
        System.exit(1);
    }

    /**
     * @see MqttCallback#deliveryComplete(IMqttDeliveryToken)
     */
    public void deliveryComplete(IMqttDeliveryToken token) {
    }

    /**
     * @see MqttCallback#messageArrived(String, MqttMessage)
     */
    public void messageArrived(String topic, MqttMessage message) throws MqttException {
        System.out.println(String.format("[%s] %s", topic, new String(message.getPayload())));
    }

    public static void main(String[] args) throws MqttException, URISyntaxException {
        HSHController s = new HSHController();
    }
}
