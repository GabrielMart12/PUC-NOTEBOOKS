#include<math.h>
#include<stdio.h>
#include<stdlib.h>

int main() {
	FILE *p = fopen("exemplo.txt", "wb");
	int numEntradas, index;
	double tmp;
	
	scanf("%d", &numEntradas);
	
	index = 0;
	while(index < numEntradas) {
		scanf("%lf", &tmp);
		fwrite(&tmp, sizeof(double), 1, p);
		index++;
	}
	fclose(p);
	
	FILE *p2 = fopen("exemplo.txt", "rb");
	index = numEntradas;
	while(index > 0) {
		fseek(p2, (index * 8) - 8, SEEK_SET);
		fread(&tmp, sizeof(double), 1, p);
		
		if(tmp - (int)tmp == 0.0) {
			printf("%d\n", (int)tmp);
		} else {
			printf("%0.3lf\n", tmp);
		}
		
		index--;
	}

	return 0;
}
