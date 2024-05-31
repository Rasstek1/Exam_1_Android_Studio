package com.racine.exam_1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Appel à la méthode onCreate de la superclasse AppCompatActivity pour effectuer les initialisations standard de l'activité
        super.onCreate(savedInstanceState)

        // Associe l'activité au fichier de layout activity_second.xml
        setContentView(R.layout.activity_second)

        // Récupérer les vues du layout activity_second.xml
        val spinner: Spinner = findViewById(R.id.spinner) // Trouve la vue Spinner dans le layout et l'associe à la variable spinner
        val listView: ListView = findViewById(R.id.listView) // Trouve la vue ListView dans le layout et l'associe à la variable listView
        val buttonShowDialog: Button = findViewById(R.id.btn_show_dialog) // Trouve la vue Button dans le layout et l'associe à la variable buttonShowDialog

        // Configurer le Spinner
        val spinnerItems = arrayOf("Item 1", "Item 2", "Item 3") // Crée un tableau de chaînes de caractères pour les éléments du Spinner
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems) // Crée un adaptateur pour le Spinner avec les éléments définis
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // Définit le layout à utiliser pour les éléments déroulants du Spinner
        spinner.adapter = spinnerAdapter // Associe l'adaptateur au Spinner pour afficher les éléments

        // Configurer le ListView
        val listViewItems = arrayOf(
            "Item 1\nSub Item 1",
            "Item 2\nSub Item 2",
            "Item 3\nSub Item 3",
            "Item 4\nSub Item 4",
            "Item 5\nSub Item 5",
            "Item 6\nSub Item 6",
            "Item 7\nSub Item 7",
            "Item 8\nSub Item 8",
            "Item 9\nSub Item 9"
        )
        val listViewAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, listViewItems)
        listView.adapter = listViewAdapter

        // Afficher un Dialog avec une image
        buttonShowDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_layout, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.edit_text)
            val dialogImage = dialogLayout.findViewById<ImageView>(R.id.dialog_image)

            // Optionnel: si vous voulez changer l'image dynamiquement
            dialogImage.setImageResource(R.drawable.toast) // Assurez-vous que 'toast_image' existe dans 'res/drawable'

            with(builder) {
                setTitle("Alert Toast")
                setMessage("Une boite de dialogue avec une image et un champ de texte.")
                setView(dialogLayout)
                setPositiveButton("OK") { dialog, _ ->
                    val inputText = editText.text.toString()
                    // Traitez l'entrée de l'utilisateur ici
                    dialog.dismiss()
                }
                setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                show()
        }
    }
}
}
