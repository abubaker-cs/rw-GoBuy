/*
 * Copyright (c) 2020 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.gobuy.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.gobuy.R
import com.raywenderlich.android.gobuy.databinding.GroceryListItemBinding
import com.raywenderlich.android.gobuy.model.GroceryItem

class GroceryAdapter(
    private val items: ArrayList<GroceryItem>,
    private val context: Context,
    val itemEditListener: (position: Int) -> Unit,
    val itemDeleteListener: (position: Int) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {
    // Gets the number of groceries in the list
    override fun getItemCount() = items.size

    // TO DO: return the binding instead of a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(context)

        // XML: grocery_list_item.xml
        val binding: GroceryListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.grocery_list_item,
            parent, false
        )

        return ViewHolder(binding)

    }

    // TO DO: remove the text setters and replace them by the binding in the view holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

        // Button: Edit
        holder.binding.buttonEdit.setOnClickListener {
            itemEditListener(position)
        }

        // Button: Delete
        holder.binding.buttonDelete.setOnClickListener {
            itemDeleteListener(position)
        }
    }
}

// TO DO: put a binding object as a parameter instead of a view
class ViewHolder(val binding: GroceryListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: GroceryItem) {
        binding.apply {
            //itemName = "${item.amount}x: ${item.itemName}"
            //price = item.price.toString()
        }
    }
}
