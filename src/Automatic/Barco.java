/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automatic;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author carls
 */
@Entity
@Table(name = "barco", catalog = "barcos", schema = "")
@NamedQueries({
    @NamedQuery(name = "Barco.findAll", query = "SELECT b FROM Barco b")
    , @NamedQuery(name = "Barco.findByNumeroMatricula", query = "SELECT b FROM Barco b WHERE b.numeroMatricula = :numeroMatricula")
    , @NamedQuery(name = "Barco.findByNombre", query = "SELECT b FROM Barco b WHERE b.nombre = :nombre")
    , @NamedQuery(name = "Barco.findByNumeroAmarre", query = "SELECT b FROM Barco b WHERE b.numeroAmarre = :numeroAmarre")
    , @NamedQuery(name = "Barco.findByCuota", query = "SELECT b FROM Barco b WHERE b.cuota = :cuota")
    , @NamedQuery(name = "Barco.findByIdSocio", query = "SELECT b FROM Barco b WHERE b.idSocio = :idSocio")})
public class Barco implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumeroMatricula")
    private Integer numeroMatricula;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "NumeroAmarre")
    private String numeroAmarre;
    @Basic(optional = false)
    @Column(name = "Cuota")
    private float cuota;
    @Column(name = "idSocio")
    private Integer idSocio;

    public Barco() {
    }

    public Barco(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public Barco(Integer numeroMatricula, String nombre, String numeroAmarre, float cuota) {
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.numeroAmarre = numeroAmarre;
        this.cuota = cuota;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        Integer oldNumeroMatricula = this.numeroMatricula;
        this.numeroMatricula = numeroMatricula;
        changeSupport.firePropertyChange("numeroMatricula", oldNumeroMatricula, numeroMatricula);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getNumeroAmarre() {
        return numeroAmarre;
    }

    public void setNumeroAmarre(String numeroAmarre) {
        String oldNumeroAmarre = this.numeroAmarre;
        this.numeroAmarre = numeroAmarre;
        changeSupport.firePropertyChange("numeroAmarre", oldNumeroAmarre, numeroAmarre);
    }

    public float getCuota() {
        return cuota;
    }

    public void setCuota(float cuota) {
        float oldCuota = this.cuota;
        this.cuota = cuota;
        changeSupport.firePropertyChange("cuota", oldCuota, cuota);
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        Integer oldIdSocio = this.idSocio;
        this.idSocio = idSocio;
        changeSupport.firePropertyChange("idSocio", oldIdSocio, idSocio);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroMatricula != null ? numeroMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barco)) {
            return false;
        }
        Barco other = (Barco) object;
        if ((this.numeroMatricula == null && other.numeroMatricula != null) || (this.numeroMatricula != null && !this.numeroMatricula.equals(other.numeroMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Automatic.Barco[ numeroMatricula=" + numeroMatricula + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
