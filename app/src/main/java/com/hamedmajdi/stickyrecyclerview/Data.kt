package com.hamedmajdi.stickyrecyclerview

data class ItemRowData(
    var title: String? = null,
    var desc: String? = null,
    var stock: Int? = null
)

data class HeaderData(
    var title: String? = null,
    var color: Int = R.color.black
)
