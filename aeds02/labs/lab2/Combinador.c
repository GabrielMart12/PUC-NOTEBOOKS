#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAXTAM 1000

int getPosEspaco(char* str);
char* getStr1(char* str, int pos);
char* getStr2(char* str, int pos);
char* getStringIntercalada(char* str1, char* str2);
char* getStrExcedente(char* maiorStr, int numExcedente);
char* getMaiorStr(char* str1, char* str2);
char* combinar(char* entrada);

int main() {
	char* entrada = (char*) malloc(MAXTAM * sizeof(char*));
	char* saida = (char*) malloc(MAXTAM * sizeof(char*));
	while(scanf(" %1000[^\n]s", entrada) == 1) {
		saida = combinar(entrada);
		printf("%s", saida);
	}
	return 0;
}

char* combinar(char* entrada) {
	char* str1 = (char*) malloc(MAXTAM * sizeof(char*));
	char* str2 = (char*) malloc(MAXTAM * sizeof(char*));
	char* resp = (char*) malloc(MAXTAM * sizeof(char*));
	
	int posEspaco = getPosEspaco(entrada);

	str1 = getStr1(entrada, posEspaco);
	str2 = getStr2(entrada, posEspaco);

	resp = getStringIntercalada(str1, str2);

	//printf("%s %s - %s\n", str1, str2, resp);
}

char* getStringIntercalada(char* str1, char* str2) {
	char* resp = (char*) malloc(MAXTAM * sizeof(char*));
	char* maiorStr = (char*) malloc(MAXTAM * sizeof(char*));
	char* strExcedente = (char*) malloc(10 * sizeof(char*));
	int numExcedente = 0;

	int i = 0, j = 0, k = 0;
	for(i = 0; i < (int)strlen(str1) + (int)strlen(str2); i++) {
		if(i % 2 == 0) {
			resp[i] = str1[j];
			j++;
		} else {
			resp[i] = str2[k];
			k++;
		}
	}

	maiorStr = getMaiorStr(str1, str2);
	numExcedente = ((int)strlen(str1) + (int)strlen(str2)) - (int)strlen(resp);
	strExcedente = getStrExcedente(maiorStr, numExcedente);

	/*
	printf("%d\n", numExcedente);
	printf("%s %d\n", resp, strlen(resp));
	strcat(resp, strExcedente);
	printf("%s %d\n", resp, strlen(resp));
	*/

	return resp;
}

char* getStrExcedente(char* maiorStr, int numExcedente) {
	char* strExcedente = (char*) malloc(10 * sizeof(char*));
	int j = 0;
	for(int i = strlen(maiorStr) - numExcedente; i < strlen(maiorStr); i++, j++) {
		strExcedente[j] = maiorStr[i];
	}
	return strExcedente;
}

char* getMaiorStr(char* str1, char* str2) {
	return strlen(str1) > strlen(str2) ? str1 : str2;
}

char* getStr1(char* str, int pos) {
	char* resp = (char*) malloc(MAXTAM * sizeof(char*));
	int i;
	
	for(i = 0; i < pos; i++) {
		resp[i] = str[i];
	}

	return resp;
}

char* getStr2(char* str, int pos) {
	char* resp = (char*) malloc(MAXTAM * sizeof(char*));
	int i = 0, j = 0;
	for(i = pos + 1; i < (int)strlen(str); i++) {
		resp[j] = str[i];
		j++;
	}

	return resp;
}

int getPosEspaco(char* str) {
	int resp;
	for(resp = 0; str[resp] != ' '; resp++); 
	return resp;
}
