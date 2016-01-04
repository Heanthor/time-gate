/**
 * Created by reedtrevelyan on 12/29/15.
 */

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import java.net.InetAddress;

public class TimeTest {
    public static void main(String[] args) {
        String TIME_SERVER = "time-c.nist.gov";
        NTPUDPClient timeClient = new NTPUDPClient();
        InetAddress inetAddress;

        try {
            inetAddress = InetAddress.getByName(TIME_SERVER);
            TimeInfo timeInfo = timeClient.getTime(inetAddress);
            long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
            System.out.println(returnTime);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
