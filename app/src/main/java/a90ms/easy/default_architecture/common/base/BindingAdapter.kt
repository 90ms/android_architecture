package a90ms.easy.default_architecture.common.base

import a90ms.easy.default_architecture.common.base.recyclerview.BaseMultiViewAdapter
import a90ms.easy.default_architecture.common.base.recyclerview.BaseSingleViewAdapter
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("bind_replaceItemList")
fun replaceItemList(recyclerView: RecyclerView, item: List<Any>?) {
    item?.let {
        @Suppress("UNCHECKED_CAST")
        (recyclerView.adapter as? BaseSingleViewAdapter<Any>)?.run {
            submitList(item)
        }

        @Suppress("UNCHECKED_CAST")
        (recyclerView.adapter as? BaseMultiViewAdapter<Any>)?.run {
            val newItems = mutableListOf<Any>()
            item.forEach {
                newItems.add(it)
            }
            submitList(newItems)
        }
    }
}