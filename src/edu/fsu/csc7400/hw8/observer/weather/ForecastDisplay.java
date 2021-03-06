/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 8
 * 
 * Date: 2017-10-20
 * 
 * Code taken from HeadFirst Object-Oriented Design Patterns sample
 */
package edu.fsu.csc7400.hw8.observer.weather;

/**
 * Forecast display
 */
public class ForecastDisplay implements Observer, DisplayElement {
	
	/**
	 * Constructor with weather data
	 * 
	 * @param weatherData
	 *            the weather data for initialization
	 * 
	 * @precondition weatherData != null
	 * @postcondition this will be registered as an observer to weatherData
	 */
	public ForecastDisplay(WeatherData weatherData) {
		weatherData.registerObserver(this);
	}

	/**
	 * Updates the display with new data
	 * 
	 * @param temp
	 *            current temperature
	 * @param humidity
	 *            current humidity level
	 * @param pressure
	 *            current barometric pressure
	 */
	public void update(float temp, float humidity, float pressure) {
                lastPressure = currentPressure;
		currentPressure = pressure;

		display();
	}

	/**
	 * Displays the data
	 */
	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}

	private float currentPressure = 29.92f;  
	private float lastPressure;

}
