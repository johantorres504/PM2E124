package com.example.pm2e124.tablas;


    public class Transacciones
    {

        //   Button btnSalvar, btnSalvados;
        //   EditText txtEditName, editarTel,txtEditNota,paises;

        //Nombre de la base de datos
        public static final String NameDatabase = "PM01DB";

        /* Creacion de las tablas de la BD */
        public static final String TbContactos = "Contactos";

        /* Campos de la tabla personas */
        public static final String id = "id";
        public static final String nombres = "nombres";
        public static final String telefono = "telefono";
        public static final String nota = "nota";
        public static final String pais = "pais";

        // DDL
        public static final String CTContactos = "CREATE TABLE Contactos (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nombres TEXT, nota TEXT, telefono INTEGER, pais TEXT)";

        public static final String GetContactos = "SELECT * FROm " + Transacciones.TbContactos;

        public static final String DropTContactos = "DROP TABLE IF EXISTS Contacto";

    }

