/**
 * Created by reedtrevelyan on 12/29/15.
 */

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import java.net.InetAddress;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class TimeTest {
    public static void main(String[] args) {
        String TIME_SERVER = "time-c.nist.gov";
        NTPUDPClient timeClient = new NTPUDPClient();
        InetAddress inetAddress;

        try {
            inetAddress = InetAddress.getByName(TIME_SERVER);
            TimeInfo timeInfo = timeClient.getTime(inetAddress);
            long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();

            Instant i = Instant.ofEpochMilli(returnTime);
            DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy KK:mm:ss a\n").withZone(ZoneId.systemDefault());
            System.out.print(f.format(i));
            System.out.println(returnTime);

            System.out.println(i.compareTo(Instant.now()));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
