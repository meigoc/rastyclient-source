// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.ui.altmanager;

import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.Agent;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.net.Proxy;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import net.minecraft.util.Session;
import net.minecraft.client.Minecraft;

public final class AltLoginThread extends Thread
{
    public final String password;
    public String status;
    public final String username;
    public Minecraft mc;
    
    public AltLoginThread(final String username, final String password) {
        super("Alt Login Thread");
        this.mc = Minecraft.getInstance();
        this.username = username;
        this.password = password;
        this.status = "Waiting...";
    }
    
    public Session createSession(final String username, final String password) {
        final YggdrasilUserAuthentication yggdrasilUserAuthentication = (YggdrasilUserAuthentication)new YggdrasilAuthenticationService(Proxy.NO_PROXY, "").createUserAuthentication(Agent.MINECRAFT);
        yggdrasilUserAuthentication.setUsername(username);
        yggdrasilUserAuthentication.setPassword(password);
        try {
            yggdrasilUserAuthentication.logIn();
            return new Session(yggdrasilUserAuthentication.getSelectedProfile().getName(), yggdrasilUserAuthentication.getSelectedProfile().getId().toString(), yggdrasilUserAuthentication.getAuthenticatedToken(), "mojang");
        }
        catch (final AuthenticationException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public String getStatus() {
        return this.status;
    }
    
    @Override
    public void run() {
        if (this.password.equals("")) {
            this.mc.session = new Session(this.username, "", "", "mojang");
            this.status = "Logged in. (" + this.username + " - offline name";
            return;
        }
        this.status = "Logging in...";
        final Session session = this.createSession(this.username, this.password);
        if (session == null) {
            this.status = "Login failed!";
        }
        else {
            this.status = (Object)"Logged in. (" + session.getUsername() + ")";
        }
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
}
