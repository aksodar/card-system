package ru.gb.cardsystem;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import ru.gb.cardsystem.controllers.impl.PanelController;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class CardSystemApplication extends JFrame {

    private static final long serialVersionUID = -2530700115365433295L;

    public static void main(final String[] args) {
        final ConfigurableApplicationContext ctx = new SpringApplicationBuilder(CardSystemApplication.class)
                .headless(false)
                .run(args);

        final PanelController panelController = new PanelController(ctx);
        panelController.initPanels();

        EventQueue.invokeLater(() -> {
            final CardSystemApplication ex = ctx.getBean(CardSystemApplication.class);
            ex.setVisible(true);
        });
    }

}
