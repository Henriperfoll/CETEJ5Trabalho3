package henriperfoll.primefaces;

import java.io.Serializable;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@Named
public class GraficoLinha implements Serializable {

	private LineChartModel graficoLinhas;
	
	@PostConstruct
	public void init() {
		createLineModel();
	}
	
	public LineChartModel initLineChart() {
		LineChartModel chart = new LineChartModel();
		Random numberGenerator = new Random();
		LineChartSeries series1 = new LineChartSeries();
		LineChartSeries series2 = new LineChartSeries();
		
		series1.setLabel("Brasil");
		series2.setLabel("Paraguay");
		for(int i = 2010; i < 2020; i++) {
			series1.set(i, numberGenerator.nextInt(5000));
			series2.set(i, numberGenerator.nextInt(5000));
		}
		
		chart.addSeries(series1);
		chart.addSeries(series2);
		
		return chart;
	}
	
	public void createLineModel() {
		this.graficoLinhas = initLineChart();
		
		this.graficoLinhas.setTitle("Vendas realizadas entre 2010 até 2019");
		this.graficoLinhas.setLegendPosition("ne");
		Axis xAxis = this.graficoLinhas.getAxis(AxisType.X);
		Axis yAxis = this.graficoLinhas.getAxis(AxisType.Y);
		
		xAxis.setLabel("Anos");
		yAxis.setLabel("Quantidade de compras");
		yAxis.setMax(5000);
		yAxis.setMin(0);
	}

	public LineChartModel getGraficoLinhas() {
		return graficoLinhas;
	}

	public void setGraficoLinhas(LineChartModel graficoLinhas) {
		this.graficoLinhas = graficoLinhas;
	}
	
	
}
