package org.particular.initialApp;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean(name = "myBean")
@ViewScoped
public class MyBean implements Serializable {

    private static final long serialVersionUID = 8301865434469950945L;

    String str = "hello";
    
    private MapModel simpleModel = new DefaultMapModel();
    
    private double latitude;
    private double longitude;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void reset(ActionEvent ae) {
        str = "";
    }

    public MapModel getSimpleModel() {
		return simpleModel;
	}
    
    public double getLatitude() {
		return latitude;
	}
    
    public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
    
    public double getLongitude() {
		return longitude;
	}
    
    public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
    
    public void adicionarMarcacao() {
    	LatLng coordenada = new LatLng(latitude, longitude);
    	
    	simpleModel.addOverlay(new Marker(coordenada, "Coordenada Informada"));
    }
    
    public void apagarMarcacao(OverlaySelectEvent event) {
    	Marker overlay = (Marker) event.getOverlay();
    	
    	simpleModel.getMarkers().remove(overlay);
    }
    
    public void capturarCoordenada(PointSelectEvent event) {
    	latitude = event.getLatLng().getLat();
    	longitude = event.getLatLng().getLng();
    }
    
    public void limparMapa() {
    	simpleModel = new DefaultMapModel();
    }
    
    public void enderecoDeCasa() {
    	latitude = -22.820492;
    	longitude = -47.265501;
    }
}
