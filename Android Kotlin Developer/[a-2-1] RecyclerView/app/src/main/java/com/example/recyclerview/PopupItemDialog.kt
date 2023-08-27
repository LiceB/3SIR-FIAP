package com.example.recyclerview

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.recyclerview.databinding.PopupItemDialogBinding

class PopupItemDialog : DialogFragment() {

    lateinit var bind: PopupItemDialogBinding
    var iDialogInference: IDialogItem? = null
    private var itemPosition: Int = -1
    private var editedItem: ItemModel? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)
        bind = PopupItemDialogBinding.inflate(layoutInflater)

        val builder = AlertDialog.Builder(requireContext())

        editedItem?.let { item ->
            bind.textView2.text = "Edição"
            bind.txtTitle.setText(item.item)
            bind.txtDescription.setText(item.detalhe)
        }

        builder.setView(bind.root)
            .setPositiveButton("Confirmar", { dialog, _ ->

                val popupItem = ItemModel(
                    bind.txtTitle.text.toString(),
                    bind.txtDescription.text.toString(),
                    false
                )
                if (itemPosition > -1) {
                    iDialogInference?.editItem(itemPosition, popupItem)
                } else {
                    iDialogInference?.addItem(
                        popupItem
                    )
                }
                dialog.cancel()
            })
            .setNegativeButton("Cancelar"){dialog, _ ->
                dialog.cancel()
            }
        return builder.create()

    }

    companion object {
        fun buildDialog(
            iDialog: IDialogItem,
            posicao: Int = -1,
            item: ItemModel? = null
        ):PopupItemDialog {
            val dialog = PopupItemDialog()
            val args = Bundle()
            dialog.iDialogInference = iDialog
            dialog.editedItem = item
            dialog.itemPosition = posicao
            dialog.arguments = args
            return dialog
        }
    }
}