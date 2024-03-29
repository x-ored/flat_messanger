package com.flat.internal.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.flat.internal.R

open class BaseFragment(var ViewId: Int) : Fragment() {

    var FragmentView : View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(ViewId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentView = view

        view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fragment_anim))
    }

    fun AppBarInit(view: View, IconId : Int, onClickListener: View.OnClickListener, AppBarText : String) {
        val AppHdrLeftButtonImg = view.findViewById<ImageView>(R.id.AppHdrLeftButtonImg)
        val AppBarTextView = view.findViewById<TextView>(R.id.AppBarTextView)

        AppHdrLeftButtonImg.setImageResource(IconId)
        AppHdrLeftButtonImg.setOnClickListener(onClickListener)
        AppBarTextView.setText(AppBarText)
    }

    fun ExecuteActionFragment(ActionId : Int, Args: Bundle) {
        FragmentView!!.findNavController().navigate(ActionId, Args)
    }

    fun ExecuteActionFragment(ActionId : Int) {
        FragmentView!!.findNavController().navigate(ActionId)
    }

    fun ShowFragmentDialog(text : String) {
        MyDialogFragment(text).show(fragmentManager!!, "dialog")
    }
}