package headFirst.chapter_10_state.gum_v1;

public enum MachineState {
    SOLD_OUT, // Все шарики распроданы
    NO_QUARTER, // Нет монетки
    HAS_QUARTER, // Есть монетка
    SOLD, // Шарик продан
}
