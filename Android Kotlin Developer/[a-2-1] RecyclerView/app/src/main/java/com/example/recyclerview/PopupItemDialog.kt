package com.example.recyclerview

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.recyclerview.databinding.PopupItemDialogBinding

class PopupItemDialog : DialogFragment() {

    lateinit var bind: PopupItemDialogBinding
    var iDialogInference: IDialogItem? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)
        bind = PopupItemDialogBinding.inflate(layoutInflater)

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(bind.root)
            .setPositiveButton("Confirmar", { dialog, _ ->
                iDialogInference?.addItem(
                    ItemModel(
                        bind.txtTitle.text.toString(),
                        bind.txtDescription.text.toString(),
                        false
                    )
                )
                dialog.cancel()
            })
            .setNegativeButton("Cancelar"){dialog, _ ->
                dialog.cancel()
            }
        return builder.create()

    }

    companion object {
        fun buildDialog(iDialog: IDialogItem):PopupItemDialog {
            val dialog = PopupItemDialog()
            val args = Bundle()
            dialog.iDialogInference = iDialog
            dialog.arguments = args
            return dialog
        }
    }
}