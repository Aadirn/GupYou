package com.ctbarbanza.gupyou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.ctbarbanza.gupyou.mockup.UserController;
import com.ctbarbanza.gupyou.models.User;
import com.ctbarbanza.gupyou.screens.ValoracionFragment;
import com.orhanobut.hawk.Hawk;

public class PerfilUsuarioActivity extends AppCompatActivity {

    private User user;
    FragmentManager manager=getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_perfil_usuario);

        user = UserController.init().getCurrentUser();

        updateProfileData();
        cargarValoraciones();
    }

    private void cargarValoraciones() {

        FragmentTransaction trans = manager.beginTransaction();
        ValoracionFragment frg = ValoracionFragment.newInstance(this.user.uid);
        trans.replace(R.id.perfil_usuario_contenedor, frg, "valoraciones");
        trans.commitNow();

    }

    private void updateProfileData() {

        User nUser = new User();
        nUser.uid       = this.user.uid;
        nUser.instagram = "INSTAGRAM-01";
        nUser.facebook  = "FACEBOOK-01";
        nUser.google    = this.user.google;
        nUser.img       = this.user.img;
        nUser.name      = this.user.name;
        nUser.nick      = this.user.nick;

        DbController.saveUser(nUser);

    }
}
