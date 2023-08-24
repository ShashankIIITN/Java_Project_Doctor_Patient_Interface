#include <iostream>
#include <math.h>
#include <string.h>
using namespace std;

int partition(int arr[], int srt, int end)
{
    int limit = arr[srt];
    int count = 0;
    for (int i = 0; i <= end; i++)
    {
        if (arr[i] <= limit)
        {
            count = i ;
        }
    }
    int c = srt + count;
    swap(arr[c], arr[srt]);
    int i = srt;
    int j = end;

    while (i < c && j > c)
    {

        while (arr[i] <= arr[c])
        {
            i++;
        }

        while (arr[j] > arr[c])
        {
            j--;
        }

        if (i < c && j > c)
        {
            swap(arr[i++], arr[j--]);
        }
    }

    return c;
}

void quick_sort(int arr[], int srt, int end)
{
    if (srt >= end)
    {
        return;
    }

    int c = partition(arr, srt, end);

    quick_sort(arr, srt, c - 1);
    quick_sort(arr, c + 1, end);
}

int main()
{
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    quick_sort(arr, 0, n - 1);

    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }

    return 0;
}