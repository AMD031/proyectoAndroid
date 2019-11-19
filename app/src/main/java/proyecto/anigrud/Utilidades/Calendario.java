package proyecto.anigrud.Utilidades;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

public class Calendario {

    public static void CreaCalendario(EditText edittext, Context context){
        final EditText et = edittext;
        int dia, mes, agno;
        final Calendar c= Calendar.getInstance();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        agno = c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                et.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },agno,mes,dia);
        datePickerDialog.show();


    }



}
