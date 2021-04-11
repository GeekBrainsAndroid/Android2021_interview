package geekbrains.ru.translator.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import geekbrains.ru.translator.databinding.ActivityMainRecyclerviewItemBinding
import geekbrains.ru.translator.model.data.DataModel

class MainAdapter(private var onListItemClickListener: OnListItemClickListener) :
    RecyclerView.Adapter<MainAdapter.RecyclerItemViewHolder>() {

    private lateinit var data: List<DataModel>

    fun setData(data: List<DataModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val item = ActivityMainRecyclerviewItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerItemViewHolder(item)
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class RecyclerItemViewHolder(private var item: ActivityMainRecyclerviewItemBinding) : RecyclerView.ViewHolder(item.root) {

        fun bind(data: DataModel) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                item.headerTextviewRecyclerItem.text = data.text
                item.descriptionTextviewRecyclerItem.text = data.meanings?.get(0)?.translation?.translation
                item.root.setOnClickListener { openInNewWindow(data) }
            }
        }
    }

    private fun openInNewWindow(listItemData: DataModel) {
        onListItemClickListener.onItemClick(listItemData)
    }

    interface OnListItemClickListener {
        fun onItemClick(data: DataModel)
    }
}
