package designmodel.listener.observer;

/**
 * create by ljs on 2020/8/6 17:53
 * description:  气象台
 */
public class WeatherStation {


    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay conditionsDisplay1 = new CurrentConditionsDisplay(weatherData);
        CurrentConditionsDisplay conditionsDispla2 = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(90.0f,10.2f, 10);

    }

}
