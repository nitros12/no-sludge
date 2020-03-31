package ben.haha.no.nosludgethanks
import net.minecraft.util.text.TextComponentString
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.EventPriority
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import org.apache.logging.log4j.Logger

@Mod(
    modid = NoSludgeThanks.MOD_ID,
    name = NoSludgeThanks.MOD_NAME,
    version = NoSludgeThanks.VERSION,
    modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter",
    acceptableRemoteVersions = "*"
)
object NoSludgeThanks {
    const val MOD_ID = "no-sludge-thanks"
    const val MOD_NAME = "No Sludge Thanks"
    const val VERSION = "2019.1-1.2.23"

    private lateinit var LOGGER: Logger

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        LOGGER = event.modLog
        LOGGER.info("Hi from no sludge!")
    }

    @Mod.EventBusSubscriber
    object ObjectRegistryHandler {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        @JvmStatic
        fun onRightClickItem(event: PlayerInteractEvent.RightClickItem) {
            if (event.itemStack.displayName == "Sludge Bucket") {
                event.entityLiving?.sendMessage(TextComponentString("Clown"))
                event.entityLiving?.health = 0.0f
                event.isCanceled = true
            }
        }
    }
}
