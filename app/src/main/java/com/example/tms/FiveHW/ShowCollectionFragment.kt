package com.example.tms.FiveHW

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.tms.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_show_collection.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ShowCollectionFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_collection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (coffee in coffeeCollection){
           addItem(coffee)
        }
    }
    private fun addItem(coffee: Coffee) {
        val item= context?.let { ConstraintLayout(it) }
        val imageView= ImageView(context).apply {
            id=View.generateViewId()
            layoutParams=ViewGroup.LayoutParams(200,200)
        }
        Picasso.get().load(coffee.imageURL).error(R.drawable.ic_error).into(imageView)
        val textViewCoffeeName=TextView(context).apply {
            text=coffee.name
            id=View.generateViewId()
        }
        val textViewPrice=TextView(context).apply {
            text=coffee.price.toString()
            id=View.generateViewId()
        }
        val horizontalLine= View(context).apply {
            id=View.generateViewId()
            layoutParams= ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1)
            setBackgroundColor(ContextCompat.getColor(context, R.color.black))
        }
        item?.let {
            with(it){
                addView(imageView)
                addView(textViewCoffeeName)
                addView(textViewPrice)
                addView(horizontalLine)
            }
        }
        val set=ConstraintSet()
        set.constrainWidth(ConstraintSet.PARENT_ID,layout_show_collection.width)
        set.clone(item)
        set.connect(imageView.id,ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,10)
        set.connect(imageView.id,ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,10)
        set.connect(textViewCoffeeName.id,ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END,20)
        set.connect(textViewCoffeeName.id,ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,20)
        set.connect(textViewPrice.id,ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END,20)
        set.connect(textViewPrice.id,ConstraintSet.TOP,textViewCoffeeName.id,ConstraintSet.BOTTOM,20)
        set.connect(horizontalLine.id,ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM)
        set.applyTo(item)
        layout_show_collection.addView(item)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShowCollectionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}