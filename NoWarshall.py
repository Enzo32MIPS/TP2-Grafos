import pandas as pd
import matplotlib.pyplot as plt
import os

# === 1. Carregar CSV corretamente (separado por ;) ===
df = pd.read_csv("resultados.csv", sep=";")

# === 2. Ignorar linhas contendo FloydWarshall já na leitura ===
df = df[df["algoritmo"].str.upper() != "FLOYDWARSHALL"]

# === 3. Corrigir coluna tempo_ms (trocar vírgula por ponto) ===
df["tempo_ms"] = (
    df["tempo_ms"]
    .astype(str)
    .str.replace(",", ".", regex=False)
    .astype(float)
)

# === 4. Listar arquivos únicos ===
arquivos = df["arquivo"].unique()

# === 5. Criar pasta de saída ===
os.makedirs("boxplots", exist_ok=True)

# === 6. Gerar gráficos ===
for arquivo in arquivos:
    df_arq = df[df["arquivo"] == arquivo]
    
    # ——— LISTA ———
    df_lista = df_arq[df_arq["estrutura"] == "LISTA"]
    if not df_lista.empty:
        plt.figure(figsize=(10, 6))
        df_lista.boxplot(column="tempo_ms", by="algoritmo")
        plt.title(f"Boxplot — LISTA — {arquivo}")
        plt.suptitle("")
        plt.ylabel("Tempo (ms)")
        plt.xticks(rotation=45)
        plt.tight_layout()
        plt.savefig(f"boxplots/{arquivo}_LISTA.png", dpi=300)
        plt.close()

    # ——— MATRIZ ———
    df_matriz = df_arq[df_arq["estrutura"] == "MATRIZ"]
    if not df_matriz.empty:
        plt.figure(figsize=(10, 6))
        df_matriz.boxplot(column="tempo_ms", by="algoritmo")
        plt.title(f"Boxplot — MATRIZ — {arquivo}")
        plt.suptitle("")
        plt.ylabel("Tempo (ms)")
        plt.xticks(rotation=45)
        plt.tight_layout()
        plt.savefig(f"boxplots/{arquivo}_MATRIZ.png", dpi=300)
        plt.close()

print("Boxplots gerados em: boxplots/ (FloydWarshall ignorado na leitura)")
