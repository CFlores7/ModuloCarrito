package com.example.carrito

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.graphics.alpha
import androidx.core.view.drawToBitmap
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var builder : AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState);

        // Ocultando barra de acciones de app
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide();


        setContentView(R.layout.activity_main)

        builder = AlertDialog.Builder(this)

        var subtotal: Int = (Integer.parseInt(txtAF.text.toString()) * 150) + (Integer.parseInt(txtJc.text.toString()) * 80) + (Integer.parseInt(txtSS.text.toString()) * 60)
        var shipping: Int = 14
        var total: Int = shipping + subtotal

        txtSubtotal.text = subtotal.toString()
        txtShipping.text = shipping.toString()
        txtTotal.text = total.toString()

        btnMinusAF.setOnClickListener(){
            if(Integer.parseInt(txtAF.text.toString())>1) {
                txtAF.text = (Integer.parseInt(txtAF.text.toString()) - 1).toString()
                txtSubtotal.text = ((Integer.parseInt(txtSubtotal.text.toString())) - 150).toString()
                txtTotal.text = (Integer.parseInt(txtSubtotal.text.toString()) + Integer.parseInt(txtShipping.text.toString())).toString()
            } else {
                txtAF.text = (Integer.parseInt(txtAF.text.toString()) - 1).toString()
                builder.setTitle("Atencion!")
                    .setMessage("Desea eliminar el producto de su carrito?")
                    .setCancelable(true)
                    .setPositiveButton("Si"){dialogInterface, it ->
                        llAF.visibility = View.GONE
                        txtSubtotal.text = ((Integer.parseInt(txtSubtotal.text.toString())) - 150).toString()
                        txtTotal.text = (Integer.parseInt(txtSubtotal.text.toString()) + Integer.parseInt(txtShipping.text.toString())).toString()
                    }
                    .setNegativeButton("No"){dialogInterface, it ->
                        dialogInterface.cancel()
                        txtAF.text = (Integer.parseInt(txtAF.text.toString()) + 1).toString();
                    }
                    .show()
            }
        }

        btnAddAF.setOnClickListener(){
            txtAF.text = (Integer.parseInt(txtAF.text.toString()) + 1).toString();
            txtSubtotal.text = ((Integer.parseInt(txtSubtotal.text.toString())) + 150).toString()
            txtTotal.text = (Integer.parseInt(txtSubtotal.text.toString()) + Integer.parseInt(txtShipping.text.toString())).toString()
        }

        btnMinusJc.setOnClickListener(){
            if(Integer.parseInt(txtJc.text.toString())>1) {
                txtJc.text = (Integer.parseInt(txtJc.text.toString()) - 1).toString()
                txtSubtotal.text = ((Integer.parseInt(txtSubtotal.text.toString())) - 80).toString()
                txtTotal.text = (Integer.parseInt(txtSubtotal.text.toString()) + Integer.parseInt(txtShipping.text.toString())).toString()
            } else {
                txtJc.text = (Integer.parseInt(txtJc.text.toString()) - 1).toString()
                builder.setTitle("Atencion!")
                    .setMessage("Desea eliminar el producto de su carrito?")
                    .setCancelable(true)
                    .setPositiveButton("Si"){dialogInterface, it ->
                        llJc.visibility = View.GONE
                        txtSubtotal.text = ((Integer.parseInt(txtSubtotal.text.toString())) - 80).toString()
                        txtTotal.text = (Integer.parseInt(txtSubtotal.text.toString()) + Integer.parseInt(txtShipping.text.toString())).toString()
                    }
                    .setNegativeButton("No"){dialogInterface, it ->
                        dialogInterface.cancel()
                        txtJc.text = (Integer.parseInt(txtJc.text.toString()) + 1).toString();
                    }
                    .show()
            }
        }

        btnAddJc.setOnClickListener(){
            txtJc.text = (Integer.parseInt(txtJc.text.toString()) + 1).toString();
            txtSubtotal.text = ((Integer.parseInt(txtSubtotal.text.toString())) + 80).toString()
            txtTotal.text = (Integer.parseInt(txtSubtotal.text.toString()) + Integer.parseInt(txtShipping.text.toString())).toString()
        }

        btnMinusSS.setOnClickListener(){
            if(Integer.parseInt(txtSS.text.toString())>1) {
                txtSS.text = (Integer.parseInt(txtSS.text.toString()) - 1).toString()
                txtSubtotal.text = ((Integer.parseInt(txtSubtotal.text.toString())) - 60).toString()
                txtTotal.text = (Integer.parseInt(txtSubtotal.text.toString()) + Integer.parseInt(txtShipping.text.toString())).toString()
            } else {
                txtSS.text = (Integer.parseInt(txtSS.text.toString()) - 1).toString()
                builder.setTitle("Atencion!")
                    .setMessage("Desea eliminar el producto de su carrito?")
                    .setCancelable(true)
                    .setPositiveButton("Si"){dialogInterface, it ->
                        llSS.visibility = View.GONE
                        txtSubtotal.text = ((Integer.parseInt(txtSubtotal.text.toString())) - 60).toString()
                        txtTotal.text = (Integer.parseInt(txtSubtotal.text.toString()) + Integer.parseInt(txtShipping.text.toString())).toString()
                    }
                    .setNegativeButton("No"){dialogInterface, it ->
                        dialogInterface.cancel()
                        txtSS.text = (Integer.parseInt(txtSS.text.toString()) + 1).toString();
                    }
                    .show()
            }
        }

        btnAddSS.setOnClickListener(){
            txtSS.text = (Integer.parseInt(txtSS.text.toString()) + 1).toString();
            txtSubtotal.text = ((Integer.parseInt(txtSubtotal.text.toString())) + 60).toString()
            txtTotal.text = (Integer.parseInt(txtSubtotal.text.toString()) + Integer.parseInt(txtShipping.text.toString())).toString()
        }

        btnBuy.setOnClickListener(){
            builder.setTitle("Atencion!")
                .setMessage("Seguro que desea comprar los productos en carrito?")
                .setCancelable(true)
                .setPositiveButton("Comprar"){dialogInterface, it ->
                    finish()
                }
                .setNegativeButton("Cancelar"){dialogInterface, it ->
                    dialogInterface.cancel()
                }
                .show()
        }

    }
}
