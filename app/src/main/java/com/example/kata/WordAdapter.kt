import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.kata.R

class WordAdapter(private val listWord: ArrayList<String>)
    : RecyclerView.Adapter<WordAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val btnWord = itemView.findViewById<Button>(R.id.btn_word)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.word_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordAdapter.ViewHolder, position: Int) {
        holder.btnWord.text = listWord[position]
        holder.btnWord.setOnClickListener {
            val uri = Uri.parse("https://www.google.com/search?q="+listWord[position])
            val intent = Intent(Intent.ACTION_VIEW, uri)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listWord.size
    }
}