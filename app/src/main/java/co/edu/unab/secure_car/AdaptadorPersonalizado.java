package co.edu.unab.secure_car;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.ViewHolder> {

    ArrayList<Carros> listadoCarros;


    public OnItemClickListener onItemClickListener;

    public AdaptadorPersonalizado(ArrayList<Carros> listadoCarros, int activity_vista_home) {
        this.listadoCarros = listadoCarros;
        this.onItemClickListener = null;
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setListadoCarros(ArrayList<Carros> listadoCarros) {
        this.listadoCarros = listadoCarros;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_vista_home, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.cargarDatos(listadoCarros.get(position));
        Carros carro =listadoCarros.get(position);
        holder.tv_marca.setText(carro.getMarca());
        holder.tv_modelo.setText(carro.getModelo());
        holder.tv_placa.setText(carro.getModelo());
        holder.tv_color.setText(carro.getModelo());
    }

    @Override
    public int getItemCount() {
        return listadoCarros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_marca;
        TextView tv_modelo;
        TextView tv_color;
        TextView tv_placa;
        Button btn_borrar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_marca = itemView.findViewById(R.id.tv_marca_vehiculo);
            tv_modelo = itemView.findViewById(R.id.tv_modelo_vehiculo);
            tv_color = itemView.findViewById(R.id.tv_color_vehiculo);
            tv_placa = itemView.findViewById(R.id.tv_placa_vehiculo);
            btn_borrar = itemView.findViewById(R.id.btn_borrar);
        }

        public void cargarDatos(Carros carros) {
            tv_marca.setText(carros.getMarca());
            tv_modelo.setText(carros.getModelo());
            tv_color.setText(carros.getColor());
            tv_placa.setText(carros.getPlaca());

            //ivPrincipal.setImageResource();

            if(onItemClickListener != null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(carros, getAdapterPosition());
                    }
                });
                btn_borrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onClickborrar(carros, getAdapterPosition());
                    }
                });
            }
        }

    }
    public interface OnItemClickListener{
        void onItemClick(Carros carros, int posicion);
        void onClickborrar(Carros carros, int posicion);
    }
}