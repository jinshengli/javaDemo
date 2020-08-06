package designmodel.listener.observer;

/**
 * create by ljs on 2020/8/6 17:38
 * description: 布告板； 观察者的实现类。
 *
 * 实现Observer接口，所以可以从WeatherData对象中获取改变。
 *
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) { // 需要weatherData;
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this); // 注册当前观察者进入 主题。
    }


    @Override
    public void display() {
        System.out.println("current conditions: " + temperature
            + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
