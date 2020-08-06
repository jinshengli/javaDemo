package designmodel.listener.observer;

import java.util.ArrayList;

/**
 * create by ljs on 2020/8/6 17:31
 * description:  主题的实现类
 */
public class WeatherData implements Subject{

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if ( i >= 0 )
            observers.remove(i);
    }

    @Override
    public void notifyObserver() {
        for ( int i = 0; i < observers.size(); ++i ) {
            Observer observer = observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() { // 当从气象站得到更新观测值时，我们通知观察者
        notifyObserver();
    }

    public void setMeasurements(float temperature, float humidity, float pressure ) {

        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();

    }


}
