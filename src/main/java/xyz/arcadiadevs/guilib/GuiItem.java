package xyz.arcadiadevs.guilib;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
@Getter
@Setter
public class GuiItem {

  private final GuiItemType type;
  private final ItemStack item;
  private final Runnable action;

}