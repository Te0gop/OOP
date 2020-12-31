package task_04_traffic_lights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        TrafficLights[] lights = Arrays
                .stream(reader.readLine().split(" "))
                .map(TrafficLights::valueOf)
                .toArray(TrafficLights[]::new);

        int n = Integer.parseInt(reader.readLine());

        //GREEN -> YELLOW -> RED -> GREEN -> YELLOW

        TrafficLights[] trafficLights = TrafficLights.values();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lights.length; j++) {

                TrafficLights swap = lights[j];
                int nextIndex = swap.ordinal() + 1;
                TrafficLights value = trafficLights[nextIndex % trafficLights.length];
                lights[j] = value;
                System.out.print(value + " ");
            }
            System.out.println();
        }


    }
}
