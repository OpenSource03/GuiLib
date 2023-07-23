package xyz.arcadiadevs.guilib;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class GuiPage {

  private Inventory inventory;

  @Getter
  private final int rows;

  private final String title;

  @Getter
  private final GuiItem[][] items;

  public GuiPage(int rows, String title) {
    this.inventory = null;
    this.rows = rows;
    this.items = new GuiItem[rows][9];
    this.title = title;
  }

  public Inventory getInventory(GuiPageType type) {
    if (inventory == null) {
      inventory = Bukkit.createInventory(null, rows * 9, title);

      for (int i = 0; i < items.length; i++) {
        for (int j = 0; j < items[i].length; j++) {
          GuiItem item = items[i][j];

          if (item == null) {
            continue;
          }

          if ((type == GuiPageType.LAST || type == GuiPageType.SINGLE)
              && item.getType() == GuiItemType.NEXT) {
            continue;
          }

          if ((type == GuiPageType.FIRST || type == GuiPageType.SINGLE)
              && item.getType() == GuiItemType.PREVIOUS) {
            continue;
          }

          inventory.setItem(i * 9 + j, items[i][j].getItem());
        }
      }
    }

    return inventory;
  }

  public Inventory getInventory() {
    return inventory;
  }

}
