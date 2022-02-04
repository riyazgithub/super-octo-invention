package com.Jan;

import java.util.Arrays;

/**
 * Problem -- Several users made a number of Facebook posts every day last month.
 * We have stored the number of daily posts in an array. We want to mine these posts for information.
 * We have k worker nodes to process the data. For optimally exploiting the temporal relationship between the posts, each worker node must process posts from one or more consecutive days.
 * There will be a master node among our k worker nodes. This node will be in charge of distributing posts to other nodes, as well as mining the posts itself.
 * an allocation of tasks to workers and the master node, the master node should get the smallest task. To efficiently utilize our resources, we want an allocation of tasks that maximizes the task allocation to the master node, so we have optimal utilization of worker nodes processing power. There can be a lot of posts a day, so input posts for each day would be in thousands.
 *
 * We’ll be provided with an array of integers representing the daily number of posts on several consecutive days.
 * Additionally, we’ll have the number of worker nodes, and our task will be to determine the maximum total posts that can be assigned to the master node.
 */
public class divideworkamongnodes {
    public static int dividePosts(int[] days, int k) {
        int left = 1, right = Arrays.stream(days).sum() / k;

        while (left < right) {
            int mid = (left + right + 1) / 2;

            // This would denote the posts we currently have
            // as we are traversing over the array
            int target = 0;

            // This would tell us how many days we would get after dividing
            // the array in `mid` amount of posts
            int divisions = 0;
            for (int posts : days) {
                target += posts;
                if (target >= mid) {
                    divisions++;
                    target = 0;
                }
            }
            if (divisions >= k)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
    public static void main( String args[] ) {
        // Driver code

        int[] dayss = {1000,2000,3000,4000,5000};
        int nodes = 3;
        System.out.println("The master node was assigned " +  dividePosts(dayss, nodes) + " posts");
    }
}
