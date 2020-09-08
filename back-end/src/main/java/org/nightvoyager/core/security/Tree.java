package org.nightvoyager.core.security;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Tree<TValue> {

    private final Node<TValue> root;

    public Tree(Node<TValue> root) {
        this.root = root;
    }

    public Node<TValue> getRoot() {
        return root;
    }

    public void dfs(Consumer<Node<TValue>> consumer) {
        dfs(getRoot(), consumer);
    }

    public void bfs(Consumer<Node<TValue>> consumer) {
        bfs(getRoot(), consumer);
    }

    private static <TValue> void dfs(Node<TValue> root,
                                     Consumer<Node<TValue>> consumer) {
        if (root.children.size() > 0) {
            root.children.forEach(it -> dfs(it, consumer));
        } else {
            consumer.accept(root);
        }
    }

    private static <TValue> void bfs(Node<TValue> root,
                                     Consumer<Node<TValue>> consumer) {
        consumer.accept(root);
        root.children.forEach(it -> bfs(it, consumer));
    }

    public static class Node<TValue> {
        @Nullable
        private final Node<TValue> parent;

        @NotNull
        private final TValue value;

        @NotNull
        private final List<Node<TValue>> children;

        public Node(@Nullable Node<TValue> parent,
                    @NotNull TValue value,
                    Node<TValue>... children) {
            this.parent = parent;
            this.value = value;
            this.children = Arrays.asList(children);
        }
    }
}
