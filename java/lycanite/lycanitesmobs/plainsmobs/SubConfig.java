package lycanite.lycanitesmobs.plainsmobs;

import lycanite.lycanitesmobs.OldConfig;

public class SubConfig extends OldConfig {
	
	// ==================================================
	//               Load Config Settings
	// ==================================================
	@Override
	public void loadSettings() {
		super.loadSettings();
		
		// ========== Feature Control ==========
		loadSetting(this.featureStrings, "Feature Control", "BiomeTypes", "Group Biome Types", "PLAINS, SAVANNA, -SNOWY");
		loadSetting(this.featureStrings, "Feature Control", "Dimensions", "Group Dimensions", "0");

		// ========== Special Feature Control ==========
		loadSetting(this.featureBools, "Feature Control", "KoboldThievery", "Kobold Thievery", true);
		loadSetting(this.featureBools, "Feature Control", "MakasOnPeaceful", "Maka Peaceful Spawning", true);
		loadSetting(this.featureBools, "Feature Control", "DespawnMakasNaturally", "Maka Natural Despawning", false);
		
		// ========== Mob Control ==========
		loadMobSettings("Kobold", 8, 10, 1, 3, "MONSTER");
		loadMobSettings("Ventoraptor", 4, 5, 1, 3, "MONSTER");
		loadMobSettings("Maka", 12, 10, 2, 5, "CREATURE");
		loadMobSettings("MakaAlpha", 6, 4, 1, 2, "CREATURE");
		loadMobSettings("Zoataur", 4, 4, 1, 3, "MONSTER");
	}
}