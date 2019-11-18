package proyecto.anigrud.presenters;

import proyecto.anigrud.interfaces.ListadoInterface;

public class ListadoPresenter implements ListadoInterface.Presenter{

    private ListadoInterface.View view;

 public ListadoPresenter(ListadoInterface.View view){
     this.view = view;
 }

 public void onClickAdd(){
    view.lanzarFormulario();
 }
 public void onClickAbout(){ view.lanzarSobre();};







}
