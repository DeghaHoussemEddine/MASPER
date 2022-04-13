module MASPER {
	requires javafx.controls;
	requires javafx.graphics;
	requires org.jsoup;
	requires javafx.base;

	opens application to javafx.graphics, javafx.fxml;
	//Java
	requires java.base;

	exports eu.hansolo.medusa;
	exports eu.hansolo.medusa.skins;
	exports eu.hansolo.medusa.events;
	exports eu.hansolo.medusa.tools;

	exports eu.hansolo.tilesfx;
	exports eu.hansolo.tilesfx.addons;
	exports eu.hansolo.tilesfx.chart;
	exports eu.hansolo.tilesfx.colors;
	exports eu.hansolo.tilesfx.events;
	exports eu.hansolo.tilesfx.fonts;
	exports eu.hansolo.tilesfx.icons;
	exports eu.hansolo.tilesfx.skins;
	exports eu.hansolo.tilesfx.tools;
	  // Java-FX

	requires transitive javafx.web;
}