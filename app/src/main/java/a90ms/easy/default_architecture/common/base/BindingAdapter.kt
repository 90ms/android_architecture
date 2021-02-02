package a90ms.easy.default_architecture.common.base

import a90ms.easy.default_architecture.common.base.recyclerview.BaseMultiViewAdapter
import a90ms.easy.default_architecture.common.base.recyclerview.BaseSingleViewAdapter
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
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

@BindingAdapter("bind_moreAction")
fun listLoadMore(
    recyclerView: RecyclerView,
    loadMoreInterface: LoadMoreInterface
) {
    recyclerView.addOnScrollListener(
        object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastPosition = layoutManager.findLastCompletelyVisibleItemPosition()

                if (lastPosition <= totalItemCount - 1) {
                    if (lastPosition == totalItemCount - LoadMoreInterface.PRE_LOAD_SIZE -1) {
                        loadMoreInterface.moreAction()
                    } else {
                        if (lastPosition == totalItemCount - 1) {
                            loadMoreInterface.moreAction()
                        }
                    }
                }
            }
        }
    )
}
