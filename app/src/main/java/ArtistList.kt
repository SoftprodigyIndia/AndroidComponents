import android.app.Activity
import android.service.autofill.TextValueSanitizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasedemo.R
import kotlinx.android.synthetic.main.item_detail.view.*
import java.util.zip.Inflater
import android.widget.ArrayAdapter as ArrayAdapter1

class ArtistList(var context: Activity, var artistList:ArrayList<Artist>) :
    RecyclerView.Adapter<ArtistList.ViewHolder>()
{



    inner  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(artist: Artist) {
            itemView.let {
                it.tvName.text=artist.artistName
                it.tvGen.text=artist.artistgenre
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item_detail,null,true)
        val myView=ViewHolder(view)
        return  myView
    }

    override fun getItemCount(): Int {
       return artistList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(artistList[position])
    }


}