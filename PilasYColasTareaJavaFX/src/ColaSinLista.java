public class ColaSinLista<T> {

    private Nodo<T> inicial;
    //Método que si está vacío el nodo inicial te dice true sino false.
    public boolean estaVacia(){
        if(inicial==null)
            return true;
        return false;
    }
    //Método que le entra un elemento y ese elemento lo coloca en un nodo que lo va a colocar en la última posición
    public void enqueue(T elemento){
        Nodo <T> nodo = new Nodo<>(elemento);
        if(estaVacia())
            inicial = nodo;
        else{
            Nodo <T> temp = inicial;
            while(temp.getSiguiente()!=null){
                temp= temp.getSiguiente();
            }
            temp.setSiguiente(nodo);
        }
    }

    //Método que te regresa el elemento de la última posición sin modificarla
    public T peek(){
        return inicial.getElemento();
    }

    //Te regresa el primer elemento que metiste a la Cola e inicial lo cambia por el siguiente.
    public T dequeue(){
        if(estaVacia())
            return null;
        else{
            Nodo<T> temp = inicial;
            inicial = inicial.getSiguiente();
            return temp.getElemento();
        }
    }


    public String listaValores(){
        String resultado = "";
        Nodo<T> temp= inicial;
        while(temp!=null){
            resultado += temp.getElemento()+"\n";
            temp= temp.getSiguiente();
        }
        return resultado;
    }




}
