package henriperfoll.primefaces;

import java.io.Serializable;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

@Named
public class GraficoBarra implements Serializable{

	private BarChartModel graficoBarras;
	
	@PostConstruct
	public void init() {
		createBarModel();
	}

	public BarChartModel getGraficoBarras() {
		return graficoBarras;
	}

	public void setGraficoBarras(BarChartModel graficoBarras) {
		this.graficoBarras = graficoBarras;
	}
	
	public BarChartModel initBarModel() {
		
		Random numberGenerator = new Random();
		BarChartModel model = new BarChartModel();
		ChartSeries series1 = new ChartSeries();
		ChartSeries series2 = new ChartSeries();
		
		series1.setLabel("Brasil");
		series2.setLabel("Paraguay");
		for(int i = 2000;i < 2010; i++) {
			series1.set(i, numberGenerator.nextInt(200));
			series2.set(i, numberGenerator.nextInt(200));
		}
		
		model.addSeries(series1);
		model.addSeries(series2);
		
		return model;
	}
	
	public void createBarModel() {
		this.graficoBarras = initBarModel();
		
		this.graficoBarras.setTitle("Vendas entre 2000 e 2009");
		this.graficoBarras.setLegendPosition("ne");
		Axis xAxis = this.graficoBarras.getAxis(AxisType.X);
		Axis yAxis = this.graficoBarras.getAxis(AxisType.Y);
		
		xAxis.setLabel("Anos");
		yAxis.setLabel("Quantidade de compras");
		yAxis.setMax(200);
		yAxis.setMin(0);
	}
}
