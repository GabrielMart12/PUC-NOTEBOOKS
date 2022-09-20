#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAXTAM 1000
#define true 1
#define false 0

int isFim(char *str);
int isPalindromo(char *str);
char* getResp(char *str);

int isFim(char *str) {
	return strlen(str) == 4 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M' && str[3] == '\n';
}

char* getResp(char *str) {
	return isPalindromo(str) == true ? "SIM" : "NAO";
}

int isPalindromo(char *str) {
	int resp = true;
	int j = (int)strlen(str) - 2;

	for(int i = 0; i < (int)strlen(str) / 2; i++) {
		if(str[i] != str[j]) {
			resp = false;
			i = (int)strlen(str);
		}
		j--;
	}

	return resp;
}

int main() {
	char **entrada = (char**) malloc(MAXTAM * sizeof(char*));
	char **saida = (char**) malloc(MAXTAM * sizeof(char*));
	int numEntrada = 0;

	do {
		entrada[numEntrada] = (char*) malloc(MAXTAM * sizeof(char*));
		saida[numEntrada] = (char*) malloc(MAXTAM * sizeof(char*));

		entrada[numEntrada] = fgets(entrada[numEntrada], MAXTAM, stdin);
		saida[numEntrada] = getResp(entrada[numEntrada]);
		
	} while(isFim(entrada[numEntrada++]) != true);
	numEntrada--;
	
	for(int i = 0; i < numEntrada; i++) {
		printf("%s\n", saida[i]);
	}

	//free(entrada);
	//free(saida);

	return 0;
}
