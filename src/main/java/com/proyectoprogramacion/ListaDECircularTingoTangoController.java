package com.proyectoprogramacion;

import com.proyectoprogramacion.listadecirculartt.Jugador;
import com.proyectoprogramacion.listadecirculartt.ListaDECTT;
import com.proyectoprogramacion.listadecirculartt.NodoDECTT;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.FlowChartConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;

/**
 *
 * @author daniel
 */
@Named(value = "listaDECircularTingoTangoController")
@SessionScoped
public class ListaDECircularTingoTangoController implements Serializable {

    public ListaDECircularTingoTangoController() {
    }

    private ListaDECTT listaJugadoresDECTT;
    private Jugador mostrarJugador;
    private NodoDECTT temp;
    private String generoWeb;
    private int datoBuscar;
    private Jugador jugadorEncontradoDECTT;

    private int posicion;
    private NodoDECTT cabezaInicial;
    private DefaultDiagramModel model;
    private int banderaPintarExtremos = 0;
    private int seleccionarUbicacion = 0;
    private int posicionInvertir1, posicionInvertir2;

    @PostConstruct
    private void iniciar() {

        listaJugadoresDECTT = new ListaDECTT();
        listaJugadoresDECTT.adicionarNodoDECTT(new Jugador("Daniel", (byte) 3, "masculino"));
        listaJugadoresDECTT.adicionarNodoDECTT(new Jugador("Dayana", (byte) 3, "femenino"));
        listaJugadoresDECTT.adicionarNodoDECTT(new Jugador("Andres", (byte) 3, "masculino"));
        listaJugadoresDECTT.adicionarNodoDECTT(new Jugador("Juan", (byte) 3, "masculino"));
        listaJugadoresDECTT.adicionarNodoDECTT(new Jugador("Alejandra", (byte) 3, "femenino"));
        listaJugadoresDECTT.adicionarNodoDECTT(new Jugador("Alex", (byte) 3, "masculino"));
        listaJugadoresDECTT.adicionarNodoDECTT(new Jugador("Camila", (byte) 3, "femenino"));
//        listaJugadoresDECTT.adicionarNodoDECTT(new Jugador("Javier", (byte) 3, "masculino"));
//        listaJugadoresDECTT.adicionarNodoDECTT(new Jugador("David", (byte) 3, "masculino"));
//        listaJugadoresDECTT.adicionarNodoDECTT(new Jugador("Cleopatra", (byte) 3, "femenino"));
//        listaJugadoresDECTT.adicionarNodoDECTT(new Jugador("Dohko", (byte) 3, "masculino"));

        mostrarJugador = listaJugadoresDECTT.getCabeza().getJugador();//para que quede mostrando el primero
        temp = listaJugadoresDECTT.getCabeza(); //al mismo objeto le pongo otro apodo        
        iniciarModeloDEC();

    }

    public ListaDECTT getListaJugadoresDECTT() {
        return listaJugadoresDECTT;
    }

    public void setListaJugadoresDECTT(ListaDECTT listaJugadoresDECTT) {
        this.listaJugadoresDECTT = listaJugadoresDECTT;
    }

    public Jugador getMostrarJugador() {
        return mostrarJugador;
    }

    public void setMostrarJugador(Jugador mostrarJugador) {
        this.mostrarJugador = mostrarJugador;
    }

    public NodoDECTT getTemp() {
        return temp;
    }

    public void setTemp(NodoDECTT temp) {
        this.temp = temp;
    }

    public String getGeneroWeb() {
        return generoWeb;
    }

    public void setGeneroWeb(String generoWeb) {
        this.generoWeb = generoWeb;
    }

    public int getDatoBuscar() {
        return datoBuscar;
    }

    public void setDatoBuscar(int datoBuscar) {
        this.datoBuscar = datoBuscar;
    }

    public Jugador getJugadorEncontradoDECTT() {
        return jugadorEncontradoDECTT;
    }

    public void setJugadorEncontradoDECTT(Jugador jugadorEncontradoDECTT) {
        this.jugadorEncontradoDECTT = jugadorEncontradoDECTT;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public NodoDECTT getCabezaInicial() {
        return cabezaInicial;
    }

    public void setCabezaInicial(NodoDECTT cabezaInicial) {
        this.cabezaInicial = cabezaInicial;
    }

    public DefaultDiagramModel getModel() {
        return model;
    }

    public void setModel(DefaultDiagramModel model) {
        this.model = model;
    }

    public int getBanderaPintarExtremos() {
        return banderaPintarExtremos;
    }

    public void setBanderaPintarExtremos(int banderaPintarExtremos) {
        this.banderaPintarExtremos = banderaPintarExtremos;
    }

    public int getSeleccionarUbicacion() {
        return seleccionarUbicacion;
    }

    public void setSeleccionarUbicacion(int seleccionarUbicacion) {
        this.seleccionarUbicacion = seleccionarUbicacion;
    }

    public int getPosicionInvertir1() {
        return posicionInvertir1;
    }

    public void setPosicionInvertir1(int posicionInvertir1) {
        this.posicionInvertir1 = posicionInvertir1;
    }

    public int getPosicionInvertir2() {
        return posicionInvertir2;
    }

    public void setPosicionInvertir2(int posicionInvertir2) {
        this.posicionInvertir2 = posicionInvertir2;
    }

//  
//    public void irPrimero() {
//        if (listaPerrosDEC.getCabeza() != null) {
//            temp = listaPerrosDEC.getCabeza();
//            perroMostrarCircular = temp.getDato();
//            posicionInvertir1 = contarPosicion();
//            iniciarModeloDEC();
//        } else {
//            JsfUtil.addErrorMessage("La lista de perros esta vacia");
//        }
//    }
//
//    public void irSiguiente() {
//        temp = temp.getSiguiente();
//        perroMostrarCircular = temp.getDato();
//        posicionInvertir1 = contarPosicion();
//        iniciarModeloDEC();
//    }
//
//    public void eliminarDEC() {
//        if (listaPerrosDEC.getCabeza() != null) {
//            listaPerrosDEC.eliminarNodoDEC(temp.getDato());
//            //iniciarModelo();
//            irPrimero();
//            iniciarModeloDEC();
//            numeroPerros--;
//        } else {
//            JsfUtil.addErrorMessage("NO hay Perros para eliminar");
//        }
//    }
    public void iniciarModeloDEC() {

        //*******************************************Metodo pintar Perros Profe*****************************
        //Instanciar e modelo
        model = new DefaultDiagramModel();
        //Definirle al modelo la cantidad de enlaces -1 (infinito)
        model.setMaxConnections(-1);

        FlowChartConnector connector = new FlowChartConnector();
        connector.setPaintStyle("{strokeStyle:'#C7B097',lineWidth:3}");
        model.setDefaultConnector(connector);

        int jugadoresPorCuadrante = 0;
        int numeroCuadrante = 1;
        int residuoNJugadores = listaJugadoresDECTT.contarNodosC() % 4;
        int cuadrante4Y = 0;
        int cuadrante2Y = 0;

        //pregunto si hay datos
        if (listaJugadoresDECTT.getCabeza() != null) {
            //Llamo a mi ayudante y lo ubico en el primero
            NodoDECTT ayudante = listaJugadoresDECTT.getCabeza();
            //recorro mientras el ayudante tenga datos
            int posX = 13;
            int posY = 0;
            int contFila = 0;
            jugadoresPorCuadrante = listaJugadoresDECTT.contarNodosC() / 4;

            if (residuoNJugadores == 3) {
                jugadoresPorCuadrante++;
                cuadrante4Y = 2;
            }

            do {

                if (contFila == jugadoresPorCuadrante) {
                    numeroCuadrante++;
                    contFila = 0;

                    if (numeroCuadrante == 2 && contFila == 0) {
                        posX = posX + 8;

                        if (residuoNJugadores == 2 || residuoNJugadores == 1) {
                            jugadoresPorCuadrante++;
                            cuadrante4Y = 3;
                        }
                    } else if (numeroCuadrante == 3 && contFila == 0) {
                        posY = posY + 4;
                    }else if (numeroCuadrante == 4 && contFila == 0) {
                        posX = posX - 8;
                    }
                }

                    switch (numeroCuadrante) {

                        case 1:
                            posX = posX + 8;
                            posY = posY;
                            break;
                        case 2:
                            posX = posX;
                            posY = posY + 5;
                            break;
                        case 3:
                            posX = posX - 8;
                            posY = posY;
                            break;
                        case 4:
                            posX = posX;
                            posY = posY - 5 - cuadrante4Y;
                            break;
                    }

                    Element perroPintar = new Element(ayudante.getJugador().getNombre(), posX + "em", posY + "em");

                    perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.RIGHT));
                    perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.LEFT));
                    model.addElement(perroPintar);
                    ayudante = ayudante.getSiguiente();

                    contFila++;

                    //condicion para que salte de fila cuando se cuenten 7 perritos
//                if (contFila  == jugadoresPorCuadrante) {
//                    
//                    
//                    
//                    
//                    
//                    posX = 25;
//                    posY = posY + 6;
//                }
//                if (contFila == datoBuscar) {
//                    perroPintar.setStyleClass("ui-diagram-success");
//                }
//                if (posicionInvertir1 == contFila || posicionInvertir2 == contFila) {
//                    perroPintar.setStyleClass("ui-diagram-invertirExtremos");
//                }
//                if (banderaPintarExtremos == 1) {
//                    if (contFila == 1) {
//                        perroPintar.setStyleClass("ui-diagram-invertirExtremos");
//                    }
//                    if (contFila == listaJugadoresDECTT.contarNodosC()) {
//                        perroPintar.setStyleClass("ui-diagram-invertirExtremos");
//                        banderaPintarExtremos = 0;
//                    }
//
//                }
                }
                while (ayudante != listaJugadoresDECTT.getCabeza());
                posicionInvertir1 = 0;
                posicionInvertir2 = 0;
                // el ayudante quedo en el enlace del último
                //Ya pinte todos los elementos y los puntos de enlace
                for (int i = 0; i < model.getElements().size() - 1; i++) {
                    model.connect(createConnection(model.getElements().get(i).getEndPoints().get(0),
                            model.getElements().get(i + 1).getEndPoints().get(1), null));
                }

                model.connect(createConnection(model.getElements().get(model.getElements().size() - 1).getEndPoints().get(0),
                        model.getElements().get(0).getEndPoints().get(1), null));
            }

        }

    

    private Connection createConnection(EndPoint from, EndPoint to, String label) {
        Connection conn = new Connection(from, to);
        conn.getOverlays().add(new ArrowOverlay(20, 20, 1, 1));
        if (label != null) {
            conn.getOverlays().add(new LabelOverlay(label, "flow-label", 0.5));
        }
        return conn;
    }

//    public int contarPosicion() {
//        int posicionActual = 1;
//        NodoDECTT temp = listaJugadoresDECTT.getCabeza();
//        while (temp.getJugador().getNumero() != mostrarJugador.getNumero()) {
//            temp = temp.getSiguiente();
//            posicionActual++;
//        }
//        return posicionActual;
//    }
//    public void sumarEdadTipoNumero() {
//        int sumaEdadesPar = 0;
//        NodoDEC temp;
//
//        if (listaPerrosDEC.contarNodosC() % 2 == 0) {
//            temp = listaPerrosDEC.getCabeza().getAnterior();        //me paro en el ultimo  
//        } else {
//            temp = listaPerrosDEC.getCabeza().getAnterior().getAnterior();
//
//        }
//        do {
//            sumaEdadesPar = sumaEdadesPar + temp.getDato().getEdad();
//            temp = temp.getAnterior().getAnterior();
//        } while (temp.getDato().getNumero() != listaPerrosDEC.getCabeza().getAnterior().getDato().getNumero());
//        if (listaPerrosDEC.contarNodosC() == 1) {
//            sumaEdad = 0;
//        } else {
//            sumaEdad = sumaEdadesPar;
//        }
//    }
//    public void sumarEdadTipoNumeroImpar() {
//        int sumaEdadesImpar = 0;
//        NodoDEC temp;
//
//        if (listaPerrosDEC.contarNodosC() % 2 == 0) {
//            temp = listaPerrosDEC.getCabeza().getAnterior().getAnterior();
//        } else {
//            temp = listaPerrosDEC.getCabeza().getAnterior();
//        }
//        while (temp.getDato().getNumero() != listaPerrosDEC.getCabeza().getDato().getNumero()) {
//            sumaEdadesImpar = sumaEdadesImpar + temp.getDato().getEdad();
//            temp = temp.getAnterior().getAnterior();
//        }
//
//        sumaEdad = sumaEdadesImpar + listaPerrosDEC.getCabeza().getDato().getEdad();
//    }
//    
}
