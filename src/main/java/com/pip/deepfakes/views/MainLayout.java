package com.pip.deepfakes.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.progressbar.ProgressBarVariant;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.wirbrauchendeinehilfe.WirbrauchendeineHilfeView;
import com.pip.deepfakes.views.lerneetwasueberdeepfakes.LerneetwasueberDeepfakesView;
import com.pip.deepfakes.views.testedeinwissen.TestedeinWissenView;
import com.pip.deepfakes.views.erkennediedeepfakes.ErkennedieDeepfakesView;
import com.pip.deepfakes.views.ueberfuehredenboesewicht.UeberfuehredenBoesewichtView;
import com.pip.deepfakes.views.dankeschoen.DankeschoenView;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.component.avatar.Avatar;

/**
 * The main view is a top-level placeholder for other views.
 */
@PreserveOnRefresh
@PWA(name = "Deepfake Webapp", shortName = "Deepfake Webapp", enableInstallPrompt = false)
@Theme(themeFolder = "deepfakewebapp", variant = Lumo.DARK)
@PageTitle("Main")
public class MainLayout extends AppLayout {

    // progress bar on top
    public static ProgressBar learnprogress = new ProgressBar(0.0, 6.0, 1.0);

    public static final Tabs tabs = new Tabs();

    // keep track of pages visited (correct progress bar behaviour)
    public static Boolean[] clickedTabs = new Boolean[6];

    public static ArrayList<Tab> tabs_instances = new ArrayList<>();

    // listener for page switches
    public static ComponentEventListener<Tabs.SelectedChangeEvent> listener;

    public static void makeProgress(int i){
        tabs_instances.get(i).setEnabled(true);
        tabs.setSelectedTab(tabs_instances.get(i));
        System.out.println(tabs_instances.get(i));
        double value = learnprogress.getValue() + 1;
        if (value <= learnprogress.getMax() && !clickedTabs[tabs.getSelectedIndex()]){
            clickedTabs[tabs.getSelectedIndex()] = true;
            learnprogress.setValue(value);
        }
    }

    public static class MenuItemInfo {

        private String text;
        private String iconClass;
        private Class<? extends Component> view;

        public MenuItemInfo(String text, String iconClass, Class<? extends Component> view) {
            this.text = text;
            this.iconClass = iconClass;
            this.view = view;
        }

        public String getText() {
            return text;
        }

        public String getIconClass() {
            return iconClass;
        }

        public Class<? extends Component> getView() {
            return view;
        }

    }

    private final Tabs menu;

    public MainLayout() {
        HorizontalLayout header = createHeader();
        menu = createMenuTabs();
        addToNavbar(createTopBar(header, menu));
    }

    private VerticalLayout createTopBar(HorizontalLayout header, Tabs menu) {
        VerticalLayout layout = new VerticalLayout();
        layout.getThemeList().add("dark");
        layout.setWidthFull();
        layout.setSpacing(true);
        layout.setPadding(true);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(header, menu, learnprogress);
        return layout;
    }

    private HorizontalLayout createHeader() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setClassName("topmenu-header");
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.setWidthFull();
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        Image logo = new Image("images/logo.png", "Deepfakes Webapp logo");
        logo.setId("logo");
        layout.add(logo);
        layout.add(new H1("Deepfakes Webapp"));

        Avatar avatar = new Avatar();
        avatar.addClassNames("ms-auto", "me-m");
        layout.add(avatar);

        return layout;
    }

    private Tabs createMenuTabs() {
        learnprogress.addThemeVariants(ProgressBarVariant.LUMO_SUCCESS);
        Arrays.fill(clickedTabs, Boolean.FALSE);

        tabs.getStyle().set("max-width", "100%");
        boolean isFirst = true;
        for (Tab menuTab : createMenuItems()) {
            tabs.add(menuTab);
            if(!isFirst){
                menuTab.setEnabled(false);
            }else{
                isFirst = false;
            }

            tabs_instances.add(menuTab);
        }
        return tabs;
    }

    /**
     * creates a listener on top tab bar
     * make progress on page switch, but only if it hasn't been clicked yet
     * TODO: extend the listener to correct page change behavior and build in barriers to impose the order of the learning platform
     */
    private void createListener(){
        listener = selectedChangeEvent -> {
                System.out.println("Pferd"); //Was??
            };
    }

    private List<Tab> createMenuItems() {
        MenuItemInfo[] menuItems = new MenuItemInfo[]{ //
                new MenuItemInfo("Wir brauchen deine Hilfe", "la la-eye", WirbrauchendeineHilfeView.class), //

                new MenuItemInfo("Lerne etwas über Deepfakes", "la la-book", LerneetwasueberDeepfakesView.class), //

                new MenuItemInfo("Teste dein Wissen", "la la-lightbulb", TestedeinWissenView.class), //

                new MenuItemInfo("Erkenne die Deepfakes", "la la-user-check", ErkennedieDeepfakesView.class), //

                new MenuItemInfo("Überführe den Bösewicht", "la la-users", UeberfuehredenBoesewichtView.class), //

                new MenuItemInfo("Dankeschön", "la la-trophy", DankeschoenView.class), //

        };
        List<Tab> tabs = new ArrayList<>();
        for (MenuItemInfo menuItemInfo : menuItems) {
            tabs.add(createTab(menuItemInfo));

        }
        return tabs;
    }

    private static Tab createTab(MenuItemInfo menuItemInfo) {
        Tab tab = new Tab();
        RouterLink link = new RouterLink();
        link.setRoute(menuItemInfo.getView());
        Span iconElement = new Span();
        iconElement.addClassNames("text-l", "pr-s");
        if (!menuItemInfo.getIconClass().isEmpty()) {
            iconElement.addClassNames(menuItemInfo.getIconClass());
        }
        link.add(iconElement, new Text(menuItemInfo.getText()));
        tab.add(link);
        ComponentUtil.setData(tab, Class.class, menuItemInfo.getView());
        return tab;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        getTabForComponent(getContent()).ifPresent(menu::setSelectedTab);
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }


}
