package proyecto.anigrud.views;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import proyecto.anigrud.R;
import proyecto.anigrud.models.Animal;

import android.view.ViewGroup;

import java.util.ArrayList;



public class AnimalAdapter
        extends RecyclerView.Adapter<AnimalAdapter.AcontecimientoViewHolder>
        implements View.OnClickListener {

    private ArrayList<Animal> items;
    private View.OnClickListener listener;

    // Clase interna:
    // Se implementa el ViewHolder que se encargará
    // de almacenar la vista del elemento y sus datos
    public static class AcontecimientoViewHolder
            extends RecyclerView.ViewHolder {

        private TextView TextView_id;
        private TextView TextView_nombre;
        private ImageView Imagen_view;

        public AcontecimientoViewHolder(View itemView) {
            super(itemView);
            TextView_id = (TextView) itemView.findViewById(R.id.textView1);
            TextView_nombre = (TextView) itemView.findViewById(R.id.textView4);
            Imagen_view = (ImageView) itemView.findViewById(R.id.imageView1);
        }

        public void AcontecimientoBind(Animal item) {
            TextView_id.setText(String.valueOf(item.getId()));
            TextView_nombre.setText(item.getNombreAnimal());

            byte[] mBase64string = item.getImagen().getBytes();
            byte[] decodedString = Base64.decode(mBase64string, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

            Imagen_view.setImageBitmap(decodedByte);

        }
    }

    // Contruye el objeto adaptador recibiendo la lista de datos
    public AnimalAdapter(@NonNull ArrayList<Animal> items) {
        this.items = items;
    }

    // Se encarga de crear los nuevos objetos ViewHolder necesarios
    // para los elementos de la colección.
    // Infla la vista del layout, crea y devuelve el objeto ViewHolder
    @Override
    public AcontecimientoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        row.setOnClickListener(this);

        AcontecimientoViewHolder avh = new AcontecimientoViewHolder(row);
        return avh;
    }

    // Se encarga de actualizar los datos de un ViewHolder ya existente.
    @Override
    public void onBindViewHolder(AcontecimientoViewHolder viewHolder, int position) {
        Animal item = items.get(position);
        viewHolder.AcontecimientoBind(item);
    }

    // Indica el número de elementos de la colección de datos.
    @Override
    public int getItemCount() {
        return items.size();
    }

    // Asigna un listener al elemento
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}