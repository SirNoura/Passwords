package ipca.exame.paswwords

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PassListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<PassListAdapter.PassViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var passwords = emptyList<Pass>() // Cached copy of words

    inner class PassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassViewHolder {
        val itemView = inflater.inflate(R.layout.recycleview_item, parent, false)
        return PassViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PassViewHolder, position: Int) {
        val current = passwords[position]
        holder.wordItemView.text = current.strPass
    }

    internal fun setWords(words: List<Pass>) {
        this.passwords = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = passwords.size
}
